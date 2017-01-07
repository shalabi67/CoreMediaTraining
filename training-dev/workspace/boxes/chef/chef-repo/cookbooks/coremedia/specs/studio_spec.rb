require File.expand_path('../helper', __FILE__)
include Coremedia::MinitestSpecHelper

describe_recipe 'coremedia::studio' do
  it "caefeeder live service is running" do
    service("cm7-studio-tomcat").must_be_running
    service("cm7-studio-tomcat").must_be_enabled
  end

  it "coremedia installation and service user has been created" do
    user(node["coremedia"]["user"]).must_exist
  end

  it "preview site is up" do
    assert_response_succeeded("http://#{node["fqdn"]}:40080/blueprint")
  end

  it "studio site is up" do
    assert_response_succeeded("http://#{node["fqdn"]}:40080/studio")
  end

  it "sitemanager site is up" do
    assert_response_succeeded("http://#{node["fqdn"]}:40080/editor-webstart")
  end
end
