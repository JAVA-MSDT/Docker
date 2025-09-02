# STEP 1: Use the official NGINX base image.
# It's a minimal Linux image with NGINX pre-installed and configured.
FROM nginx:alpine

# STEP 2: Copy our custom HTML file from the host machine...
# ...and overwrite the default NGINX welcome page inside the container.
COPY hello.html /usr/share/nginx/html/hello.html

# (OPTIONAL) The NGINX image already has EXPOSE 80, so we don't need to repeat it.
# It documents that the container listens on port 80.
