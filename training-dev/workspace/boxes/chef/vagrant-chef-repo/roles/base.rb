name 'base'
description 'The base role for CoreMedia Vagrant boxes'
#noinspection RubyStringKeysInHashInspection
override_attributes(
        'coremedia' => {
                'tomcat' => {'manager' => {'credentials' => {
                        'admin' => {
                                'username' => 'admin',
                                'password' => 'tomcat',
                                'roles' => 'manager-gui'
                        },
                        'script' => {
                                'username' => 'script',
                                'password' => 'tomcat',
                                'roles' => 'manager-jmx,manager-script'
                        }
                }}},
                'minitest' => {
                        'report_root' => '/shared/minitest-reports'
                },
                "logging" => {"default" => {
                        "com.coremedia" => {"level" => "info"},
                        "cap.server" => {"level" => "info"},
                        "hox.corem.server" => {"level" => "info"},
                        "workflow.server" => {"level" => "info"}
                }}
        },
        'psdash' => {
                'logs' => ['/var/log/messages', '/var/log/**/*.log', '/var/log/**/*.out']
        },
        # activates the update repo for python installation
        'yum' => {'updates' => {'managed' => true}}
)
run_list 'recipe[java::set_java_home]',
         'recipe[blueprint-yum::default]',
         'recipe[coremedia::reporting]',
         'recipe[coremedia::minitest]',
         'recipe[coremedia::default]',
         'recipe[psdash::default]'
