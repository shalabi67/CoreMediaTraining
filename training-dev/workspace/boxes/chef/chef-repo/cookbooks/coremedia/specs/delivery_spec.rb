require File.expand_path('../helper', __FILE__)
include Coremedia::MinitestSpecHelper

describe_recipe 'coremedia::delivery' do

  it "caefeeder live service is running" do
    service("cm7-delivery-tomcat").must_be_running
    service("cm7-delivery-tomcat").must_be_enabled
  end

  it "coremedia installation and service user has been created" do
    user(node["coremedia"]["user"]).must_exist
  end

  it "live site is up" do
    assert_response_succeeded("http://#{node["fqdn"]}:49080/blueprint")
  end
end