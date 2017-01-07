require File.expand_path('../helper', __FILE__)
include Coremedia::MinitestSpecHelper

describe_recipe 'coremedia::solr_master' do
  it "solr master service is running" do
    service("cm7-solr-master-tomcat").must_be_running
    service("cm7-solr-master-tomcat").must_be_enabled
  end

  it "coremedia installation and service user has been created" do
    user(node["coremedia"]["user"]).must_exist
  end

  it "solr master is up" do
    assert_response_succeeded("http://#{node["fqdn"]}:44080/solr")
  end
end
