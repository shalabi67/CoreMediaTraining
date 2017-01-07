coremedia_tool "cm7-cae-live-tools"

coremedia_service "cm7-delivery-tomcat"

coremedia_logging "cm7-delivery-tomcat" do
  webapps "blueprint"
  pattern '%d %-7([%level]) %logger [%X{tenant}] - %message \\\\(%thread\\\\)%n'
end

coremedia_probedog "cm7-cae-live-tools" do
  action :nothing
  probe "ProbeCae"
  timeout node["coremedia"]["probedog"]["timeout"]
  subscribes :check, "service[cm7-delivery-tomcat]", :delayed
end
