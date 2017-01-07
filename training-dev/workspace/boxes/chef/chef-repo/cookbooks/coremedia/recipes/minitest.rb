chef_gem "ci_reporter" do
  version "1.9.3"
end

chef_gem "minitest" do
  version "4.7.3"
end

chef_gem "minitest-chef-handler" do
  version "1.0.3"
  options '--ignore-dependencies --conservative'
end

require 'minitest-chef-handler'

chef_handler "MiniTest::Chef::Handler" do
  source "minitest-chef-handler"
  arguments :ci_reports => node["coremedia"]["minitest"]["report_root"]
  action :nothing
end.run_action(:enable)
