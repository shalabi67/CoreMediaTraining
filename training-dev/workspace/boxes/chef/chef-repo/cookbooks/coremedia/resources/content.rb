#
# Cookbook Name:: coremedia
# Resource:: content
#
# This Lightweight resource (LWR) represents content to import and publish and if present also users to restore.

actions :unpack, :import, :bulkpublish
default_action :nothing

attribute :archive, :kind_of => String
attribute :cms_tools, :kind_of => String, :default => "/opt/coremedia/cm7-cms-tools"
attribute :working_dir, :kind_of => String, :default => "/opt/coremedia/data"
attribute :content_folder, :kind_of => String, :default => "content"
attribute :users_file, :kind_of => String, :default => "users/users.xml"
attribute :username, :kind_of => String, :default => "admin"
attribute :password, :kind_of => String, :default => "admin"
attribute :timeout, :kind_of => Integer, :default => 300
