#
# Cookbook Name:: coremedia
# Provider:: content
#
#  This lightweight provider (LWP) provides the action to import and bulkpublish content and to restore users.
#  The provider needs the content and users in the form of a zip file, that will be extracted and imported,
#  if it has changed compared to the last imported state.
#

include Chef::Mixin::Checksum

action :unpack do
  require 'fileutils'

  if ::File.exists?(@new_resource.archive)
    archive_target = "#{new_resource.working_dir}/#{::File.basename(@new_resource.archive)}"
    if !::File.exists?(archive_target) or checksum(@new_resource.archive) != checksum(archive_target)
      FileUtils.copy_file(@new_resource.archive, archive_target)
      if platform_family?("windows")
        windows_zipfile @new_resource.working_dir do
          source archive_target
          action :unzip
        end
      else
        FileUtils.chown(node["coremedia"]["user"], node["coremedia"]["user"], archive_target)
        `unzip -uo -qq #{archive_target} -d #{new_resource.working_dir}`
      end
      new_resource.updated_by_last_action(true)
    end
  else
    raise("#{new_resource.name} - content zip file not found at #{new_resource.archive}")
  end
end

action :import do
  coremedia_probedog "check-cms-before-import" do
    tool_name "cm7-cms-tools"
    action :check
    probe "ProbeContentServerOnline"
    timeout node["coremedia"]["probedog"]["timeout"]
  end

  if ::File.exists?("#{new_resource.working_dir}/#{new_resource.content_folder}")
    Chef::Log.info("#{new_resource.name} - importing content from #{new_resource.working_dir}/#{new_resource.content_folder}")
    if platform_family?("windows")
      `#{new_resource.cms_tools}\\bin\\cm64 serverimport -r -u #{new_resource.username} -p #{new_resource.password} --no-validate-xml #{node["coremedia"]["serverimport"]["extra_options"]} #{new_resource.working_dir}/#{new_resource.content_folder}`
    else
      `su - #{node["coremedia"]["user"]} -c "#{new_resource.cms_tools}/bin/cm serverimport -r -u #{new_resource.username} -p #{new_resource.password} --no-validate-xml #{node["coremedia"]["serverimport"]["extra_options"]} #{new_resource.working_dir}/#{new_resource.content_folder}"`
    end
    new_resource.updated_by_last_action(true)
  else
    Chef::Log.info("#{new_resource.name} - No content found at #{new_resource.working_dir}/#{new_resource.content_folder} skip importing")
  end

  if ::File.exists?("#{new_resource.working_dir}/#{new_resource.users_file}")
    Chef::Log.info("#{new_resource.name} - importing users from #{new_resource.working_dir}/#{new_resource.users_file}")
    if platform_family?("windows")
      `#{new_resource.cms_tools}\\bin\\cm64 restoreusers -u #{new_resource.username} -p #{new_resource.password} -f #{new_resource.working_dir}/#{new_resource.users_file}`
    else
      `su - #{node["coremedia"]["user"]} -c "#{new_resource.cms_tools}/bin/cm restoreusers -u #{new_resource.username} -p #{new_resource.password} -f #{new_resource.working_dir}/#{new_resource.users_file}"`
    end
    new_resource.updated_by_last_action(true)
  else
    Chef::Log.info("#{new_resource.name} - No user definitions found at #{new_resource.working_dir}/#{new_resource.users_file} skip importing")
  end
end

action :bulkpublish do
  Chef::Log.info("#{new_resource.name} - bulkpublish content")
  coremedia_probedog "check-cms-before-publish" do
    tool_name "cm7-cms-tools"
    action :check
    probe "ProbeContentServerOnline"
    timeout node["coremedia"]["probedog"]["timeout"]
  end
  coremedia_probedog "check-mls-before-publish" do
    tool_name "cm7-mls-tools"
    action :check
    probe "ProbeContentServerOnline"
    timeout node["coremedia"]["probedog"]["timeout"]
  end

  if platform_family?("windows")
    `#{new_resource.cms_tools}\\bin\\cm64 bulkpublish -u #{new_resource.username} -p #{new_resource.password} -a -b -c`
    `#{new_resource.cms_tools}\\bin\\cm64 bulkpublish -u #{new_resource.username} -p #{new_resource.password} -a -ub -f /Home`
  else
    `su - #{node["coremedia"]["user"]} -c "#{new_resource.cms_tools}/bin/cm bulkpublish -u #{new_resource.username} -p #{new_resource.password} -a -b -c"`
    `su - #{node["coremedia"]["user"]} -c "#{new_resource.cms_tools}/bin/cm bulkpublish -u #{new_resource.username} -p #{new_resource.password} -a -ub -f /Home"`
  end
  new_resource.updated_by_last_action(true)
end
