require File.expand_path('../helper', __FILE__)
include Coremedia::MinitestSpecHelper

describe_recipe 'coremedia::content_management_server' do

  it "content management server service is running" do
    service("cm7-cms-tomcat").must_be_running
    service("cm7-cms-tomcat").must_be_enabled
  end

  it "coremedia installation and service user has been created" do
    user(node["coremedia"]["user"]).must_exist
  end

  it "content management server ior is available" do
    assert_response_succeeded("http://#{node["fqdn"]}:41080/coremedia/ior")
  end

  it "content management server runlevel is online" do
    assert_jmx("http://#{node["fqdn"]}:41080/manager/jmxproxy/?get=com.coremedia:type=Server,application=coremedia&att=RunLevel", "online.*")
  end

  it "contentfeeder is running" do
    assert_jmx("http://#{node["fqdn"]}:41080/manager/jmxproxy/?get=com.coremedia:type=Feeder,application=contentfeeder&att=State", "running|initializing")
  end
end