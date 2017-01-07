require 'minitest/spec'
require 'net/http'
require 'uri'
module Coremedia
  module MinitestSpecHelper
    include MiniTest::Chef::Assertions
    include MiniTest::Chef::Context
    include MiniTest::Chef::Resources

    def jmx_proxy_credentials
      result = node["coremedia"]["tomcat"]["manager"]["credentials"].values.select { |e| e["roles"]=~ /.*manager-jmx.*/ }
      unless result.empty?
        result.first
      end
    end

    def assert_jmx(url, response_matcher)
      response = fetchJmx(url)
      assert(response.code == "200", "request failed for #{url}, #{response.body}")
      assert(response.body =~ /#{response_matcher}/, "response body did non matched #{response_matcher}, body = #{response.body}")
    end

    def fetchJmx(url)
      credentials = jmx_proxy_credentials
      if credentials.nil?
        Chef::Log.warn("cannot execute jmx tests as there is no tomcat user with role manager-jmx")
      else
        uri = ::URI.parse(url)
        request = Net::HTTP::Get.new uri.request_uri
        request.basic_auth credentials["username"], credentials["password"]
        Net::HTTP.start(uri.host, uri.port) do |http|
          http.request(request)
        end
      end
    end

    def assert_response_succeeded(url)
      response = fetch(url, 10)
      assert(response.code == "200", "request failed for #{url}")
    end

    def fetch(uri_str, limit = 10)
      response = Net::HTTP.get_response(URI(uri_str))
      case response
        when Net::HTTPRedirection then
          location = response["location"]
          fetch(location, limit - 1)
        else
          response
      end
    end

    def used_recipe_names
      if recipes = run_status.node.run_state[:seen_recipes]
        recipes.keys
      else
        # chef 11 - see http://docs.getchef.com/release/11-0/release_notes.html#node-run-state-seen-recipes-replaced
        run_status.run_context.loaded_recipes
      end
    end
  end
end
