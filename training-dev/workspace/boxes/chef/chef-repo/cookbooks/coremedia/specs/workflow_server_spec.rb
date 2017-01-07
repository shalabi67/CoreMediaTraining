require File.expand_path('../helper', __FILE__)
include Coremedia::MinitestSpecHelper

describe_recipe 'coremedia::workflow_server' do
  it "workflow server service is running" do
    service("cm7-wfs-tomcat").must_be_running
    service("cm7-wfs-tomcat").must_be_enabled
  end

  it "coremedia installation and service user has been created" do
    user(node["coremedia"]["user"]).must_exist
  end

  it "workflow server ior is available" do
    assert_response_succeeded("http://#{node["fqdn"]}:43080/workflow/ior")
  end

  it "workflow server UAPI connection WorkflowRepository is available" do
    assert_jmx("http://#{node["fqdn"]}:43080/manager/jmxproxy/?get=com.coremedia:type=CapConnection,application=workflow&att=WorkflowRepositoryAvailable", "true.*")
  end
end
