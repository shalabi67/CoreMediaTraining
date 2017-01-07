name "management"
description "The role for CoreMedia Management nodes"

#noinspection RubyStringKeysInHashInspection
override_attributes "mysql" => {"bind_address" => "127.0.0.1", "use_upstart" => false, "tunable" => {"wait_timeout" => "7200"}},
                    "coremedia" => {
                            "db" => {"schemas" => %w(cm7management cm7master cm7caefeeder cm7mcaefeeder)},
                            "content_archive_url" => "s3-eu-west-1://upload.cm7.coremedia.com/snapshot/com/coremedia/blueprint/boxes/11-SNAPSHOT/boxes-11-20121127.134452-4-content-users.zip",
                    }

run_list "role[base]",
         "recipe[mysql::server]",
         "recipe[coremedia::db_schemas]",
         "recipe[mongodb]",
         "recipe[coremedia::solr_master]",
         "recipe[coremedia::master_live_server]",
         "recipe[coremedia::content_management_server]",
         "recipe[coremedia::workflow_server]",
         "recipe[coremedia::caefeeder_preview]",
         "recipe[coremedia::caefeeder_live]"
