#
# Cookbook Name:: coremedia
# Provider:: probedog
# This lightweigt provider (LWP) will probe against a service until a timeout is reached

require 'timeout'

def whyrun_supported?
  true
end

use_inline_resources

action :check do
  tools_path = "#{node["coremedia"]["install_root"]}/#{new_resource.tool_name}"
  check_retries = @new_resource.timeout / 10
  unless ::File.exists?("#{tools_path}/bin/probedog.jpif") and ::File.exists?("#{tools_path}/bin/cm")
    raise Chef::Exceptions::FileNotFound, ("#{new_resource.tool_name} - either the probedog.jpif or the cm executable are missing below #{tools_path}/bin")
  end

  Chef::Log.debug("#{new_resource.tool_name} - executing Probedog #{new_resource.probe} with Timeout = #{new_resource.timeout} seconds")

  if platform_family?("windows")
    exec_command = "#{tools_path}\\bin\\cm64 probedog #{new_resource.probe}"
  else
    exec_command = "su - #{node["coremedia"]["user"]} -c '#{tools_path}/bin/cm probedog #{new_resource.probe}'"
  end

  execute "#{new_resource.name}_#{new_resource.probe}" do
    command exec_command
    retry_delay 10
    retries check_retries.to_i
    timeout 30
  end
end
