default['blueprint']['yum']['mongodb']['managed']         = true
default['blueprint']['yum']['mongodb']['baseurl']         = "http://downloads-distro.mongodb.org/repo/redhat/os/#{node['kernel']['machine'] =~ /x86_64/ ? 'x86_64' : 'i686'}"
default['blueprint']['yum']['mongodb']['mirrorlist']      = nil
default['blueprint']['yum']['mongodb']['gpgcheck']        = false
default['blueprint']['yum']['mongodb']['gpgkey']          = nil
default['blueprint']['yum']['mongodb']['enabled']         = true
default['blueprint']['yum']['mongodb']['exclude']         = nil
default['blueprint']['yum']['mongodb']['enablegroups']    = nil
default['blueprint']['yum']['mongodb']['http_caching']    = 'all'
default['blueprint']['yum']['mongodb']['include_config']  = nil
default['blueprint']['yum']['mongodb']['includepkgs']     = nil
default['blueprint']['yum']['mongodb']['max_retries']     = '2'
default['blueprint']['yum']['mongodb']['metadata_expire'] = nil
default['blueprint']['yum']['mongodb']['mirror_expire']   = nil
default['blueprint']['yum']['mongodb']['priority']        = '1'
default['blueprint']['yum']['mongodb']['proxy']           = nil
default['blueprint']['yum']['mongodb']['proxy_username']  = nil
default['blueprint']['yum']['mongodb']['proxy_password']  = nil
default['blueprint']['yum']['mongodb']['timeout']         = '30'
