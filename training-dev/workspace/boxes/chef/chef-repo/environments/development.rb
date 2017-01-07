name "development"
description "Development Environment"

#noinspection RubyStringKeysInHashInspection
override_attributes "coremedia" => {"logging" => {"default" => {
        "com.coremedia" => {"level" => "info"},
        "cap.server" => {"level" => "info"},
        "hox.corem.server" => {"level" => "info"},
        "workflow.server" => {"level" => "info"},
}}}
