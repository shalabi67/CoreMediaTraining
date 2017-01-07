require File.expand_path('../helper', __FILE__)
include Coremedia::MinitestSpecHelper

describe_recipe 'coremedia::solr_slave' do
  it "solr slave service is running" do
    service("cm7-solr-slave-tomcat").must_be_running
    service("cm7-solr-slave-tomcat").must_be_enabled
  end

  it "coremedia installation and service user has been created" do
    user(node["coremedia"]["user"]).must_exist
  end

  it "solr slave is up" do
    assert_response_succeeded("http://#{node["fqdn"]}:45080/solr")
  end
end
