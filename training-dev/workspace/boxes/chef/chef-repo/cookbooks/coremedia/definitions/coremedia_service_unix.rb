define :coremedia_service_unix do
  package_name = params[:name]
  initial_install = !(system("rpm -qi #{package_name} > /dev/null"))
  version_to_install = node["coremedia"]["version"]["#{package_name}"].nil? ? node["coremedia"]["version"]["global"] : node["coremedia"]["version"]["#{package_name}"]

  if initial_install
    # on initial run we don't need to trigger restarts on the service
    if version_to_install.nil?
      # install latest version
      yum_package "#{package_name}" do
	retries node["coremedia"]["package"]["retries"]
        action :upgrade
      end
    else
      # install specific version
      yum_package "#{package_name}" do
        retries node["coremedia"]["package"]["retries"]
        version version_to_install
        action :install
      end
    end

    coremedia_configuration "#{package_name}" do
      action :configure
      reconfigure_cmd "service #{package_name} reconfigure"
    end

    template "#{package_name}_tomcat_users" do
      action :create
      source "tomcat_users.erb"
      path "#{node["coremedia"]["install_root"]}/#{package_name}/conf/tomcat-users.xml"
      owner node["coremedia"]["user"]
      group node["coremedia"]["user"]
      mode "0644"
      variables({
                        :credentials => node["coremedia"]["tomcat"]["manager"]["credentials"]
                })
      not_if { node["coremedia"]["tomcat"]["manager"]["credentials"].empty? }
    end

  else
    # now we need to trigger restarts on service
    if version_to_install.nil?
      # install latest
      yum_package "#{package_name}" do
        retries node["coremedia"]["package"]["retries"]
        action :upgrade
        notifies :restart, "service[#{package_name}]", :delayed
      end
    else
      # install specific version and allow downgrade
      yum_package "#{package_name}" do
        retries node["coremedia"]["package"]["retries"]
        version version_to_install
        action :install
        allow_downgrade true
        notifies :restart, "service[#{package_name}]", :delayed
      end
    end

    coremedia_configuration "#{package_name}" do
      action :configure
      reconfigure_cmd "service #{package_name} reconfigure"
      notifies :restart, "service[#{package_name}]", :delayed
    end

    template "#{package_name}_tomcat_users" do
      action :create
      source "tomcat_users.erb"
      path "#{node["coremedia"]["install_root"]}/#{package_name}/conf/tomcat-users.xml"
      owner node["coremedia"]["user"]
      group node["coremedia"]["user"]
      mode "0644"
      variables({
                        :credentials => node["coremedia"]["tomcat"]["manager"]["credentials"]
                })
      not_if { node["coremedia"]["tomcat"]["manager"]["credentials"].empty? }
      notifies :restart, "service[#{package_name}]", :delayed
    end
  end

  service package_name do
    supports :start => true, :stop => true, :restart => true, :status => true, :reload => true
    action [:enable, :start]
  end
end
