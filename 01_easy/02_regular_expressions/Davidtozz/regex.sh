awk -F/ '{ if ($2 ~ /^[A-Z]{2,4}($|[[:space:]])/) print $1 }' file.txt
