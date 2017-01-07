coremedia_tool "cm7-cms-tools"

coremedia_service "cm7-cms-tomcat"

coremedia_logging "cm7-cms-tomcat" do
  webapps %w(coremedia contentfeeder user-changes)
end

coremedia_probedog "cm7-cms-tools" do
  action :nothing
  probe "ProbeContentServerOnline"
  timeout node["coremedia"]["probedog"]["timeout"]
  subscribes :check, "service[cm7-cms-tomcat]", :delayed
  subscribes :check, "service[cm7-cms-tomcat_restart]", :delayed
end

unless node["coremedia"]["content_archive_url"].empty?
  directory File.dirname(node["coremedia"]["content_archive"]) do
    unless platform_family?("windows")
      owner node["coremedia"]["user"]
    end
    recursive true
  end

  if node["coremedia"]["content_archive_url"] =~ /s3-.*/
    credentials = Chef::EncryptedDataBagItem.load("credentials", "aws")
    s3_file node["coremedia"]["content_archive"] do
      source node["coremedia"]["content_archive_url"]
      access_key_id credentials["access_key"]
      secret_access_key credentials["secret_key"]
    end
  else
    remote_file node["coremedia"]["content_archive"] do
      backup false
      unless platform_family?("windows")
        group node["coremedia"]["user"]
        owner node["coremedia"]["user"]
      end
      source node["coremedia"]["content_archive_url"]
    end
  end
end

working_directory = "#{node["coremedia"]["install_root"]}/data"

directory working_directory do
  unless platform_family?("windows")
    owner node["coremedia"]["user"]
    group node["coremedia"]["user"]
  end
  recursive true
end

unless platform_family?("windows")
  package "unzip" do
    retries node["coremedia"]["package"]["retries"]
    only_if { ::File.exists?(node["coremedia"]["content_archive"]) }
  end
end

coremedia_content "unpack-content" do
  action :unpack
  archive node["coremedia"]["content_archive"]
  working_dir working_directory
  only_if { ::File.exists?(node["coremedia"]["content_archive"]) }
end

coremedia_content "import-content" do
  action :nothing
  working_dir working_directory
  cms_tools "#{node["coremedia"]["install_root"]}/cm7-cms-tools"
  subscribes :import, "coremedia_content[unpack-content]", :delayed
end

# this resource execution implies that the master_live_server recipe is executed before the content_management_server recipe
coremedia_content "publish-content" do
  action :nothing
  ignore_failure true
  cms_tools "#{node["coremedia"]["install_root"]}/cm7-cms-tools"
  subscribes :bulkpublish, "coremedia_content[import-content]", :delayed
end
