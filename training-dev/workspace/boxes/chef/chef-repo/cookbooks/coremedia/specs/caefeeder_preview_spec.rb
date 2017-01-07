require File.expand_path('../helper', __FILE__)
include Coremedia::MinitestSpecHelper

describe_recipe 'coremedia::caefeeder_preview' do

  it "caefeeder preview service is running" do
    service("cm7-caefeeder-preview-tomcat").must_be_running
    service("cm7-caefeeder-preview-tomcat").must_be_enabled
  end

  it "coremedia installation and service user has been created" do
    user(node["coremedia"]["user"]).must_exist
  end

  it "caefeeder heartbeat via JMX is OK" do
    assert_jmx("http://#{node["fqdn"]}:46080/manager/jmxproxy/?get=com.coremedia:type=ProactiveEngine,application=caefeeder&att=HeartBeat", "OK.*")
    assert_jmx("http://#{node["fqdn"]}:46080/manager/jmxproxy/?get=com.coremedia:type=Trigger,application=caefeeder&att=Initializing", "false")
  end
end