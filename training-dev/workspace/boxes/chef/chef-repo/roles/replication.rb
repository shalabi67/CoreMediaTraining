name "replication"
description "The role for CoreMedia Replication nodes"

#noinspection RubyStringKeysInHashInspection
override_attributes "mysql" => {"bind_address" => "127.0.0.1", "use_upstart" => false, "tunable" => {"wait_timeout" => "7200"}},
                    "coremedia" => {"db" => {"schemas" => %w(cm7replication)}}

run_list "role[base]",
         "recipe[coremedia::management_configuration_override]",
         "recipe[mysql::server]",
         "recipe[coremedia::db_schemas]",
         "recipe[coremedia::solr_slave]",
         "recipe[coremedia::replication_live_server]"
