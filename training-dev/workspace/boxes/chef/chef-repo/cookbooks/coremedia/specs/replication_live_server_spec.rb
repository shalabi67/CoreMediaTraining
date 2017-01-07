require File.expand_path('../helper', __FILE__)
include Coremedia::MinitestSpecHelper

describe_recipe 'coremedia::replication_live_server' do
  it "replication live server service is running" do
    service("cm7-rls-tomcat").must_be_running
    service("cm7-rls-tomcat").must_be_enabled
  end

  it "coremedia installation and service user has been created" do
    user(node["coremedia"]["user"]).must_exist
  end

  it "replication live server ior is available" do
    assert_response_succeeded("http://#{node["fqdn"]}:48080/coremedia/ior")
  end

  it "replication live server runlevel is online" do
    assert_jmx("http://#{node["fqdn"]}:48080/manager/jmxproxy/?get=com.coremedia:type=Server,application=coremedia&att=RunLevel", "online.*")
  end
end
