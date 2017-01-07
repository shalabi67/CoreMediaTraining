#
# Cookbook Name:: coremedia
# Provider:: workflows
#
#  This lightweight provider (LWP) provides the action to upload one ore multiple workflows

action :upload do
  begin
    # check if workflowserver is available
    Timeout::timeout(new_resource.timeout) do
      if platform_family?("windows")
        command = "#{new_resource.wfs_tools}\\bin\\cm64 probedog ProbeWorkflowServer > NUL"
      else
        command = "su - #{node["coremedia"]["user"]} -c '#{new_resource.wfs_tools}/bin/cm probedog ProbeWorkflowServer' > /dev/null"
      end
      until system(command)
        sleep(10) # sec
      end
      Chef::Log.debug("Probedog for CoreMedia Workflow Server returned successfully")
    end
  rescue Timeout::Error
    Chef::Log.error("Probedog for CoreMedia Workflow Server failed")
    raise("The Workflowserver probedog timed out after 300 seconds, cannot upload workflows")
  end

  dirty = false
  upload_cmd = "su - #{node["coremedia"]["user"]} -c '#{new_resource.wfs_tools}/bin/cm upload -u #{new_resource.username} -p #{new_resource.password}"
  unless new_resource.builtin_workflows.empty?
    Chef::Log.info("#{new_resource.name} - Uploading built-in workflows #{new_resource.builtin_workflows}")
    if platform_family?("windows")
      `#{new_resource.wfs_tools}\\bin\\cm64 upload -u #{new_resource.username} -p #{new_resource.password} -n #{new_resource.builtin_workflows.join(' ')}`
    else
      `#{upload_cmd} -n #{new_resource.builtin_workflows.join(' ')}'`
    end
    dirty = true
  end

  unless new_resource.definition.empty?
    if new_resource.jar.empty?
      Chef::Log.info("#{new_resource.name} - Uploading custom workflow from processdefinition #{new_resource.definition}")
      if platform_family?("windows")
        `#{new_resource.wfs_tools}\\bin\\cm64 upload -u #{new_resource.username} -p #{new_resource.password} -f #{new_resource.definition}`
      else
        `#{upload_cmd} -f #{new_resource.definition}'`
      end
    else
      Chef::Log.info("#{new_resource.name} - Uploading custom workflow from processdefinition #{new_resource.definition} together with jar #{new_resource.jar}")
      if platform_family?("windows")
        `#{new_resource.wfs_tools}\\bin\\cm64 upload -u #{new_resource.username} -p #{new_resource.password} -j #{new_resource.jar} -f #{new_resource.definition}`
      else
        `#{upload_cmd} -j #{new_resource.jar} -f #{new_resource.definition}'`
      end
    end
    dirty = true
  end
  if dirty
    new_resource.updated_by_last_action(true)
  end
end
