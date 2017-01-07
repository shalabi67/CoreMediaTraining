RewriteCond %{HTTPS} off
RewriteRule (.*) https://%{HTTP_HOST}%{REQUEST_URI}

RewriteCond %{REQUEST_URI} ^/$
RewriteRule ^/$ /studio/$1 [R]