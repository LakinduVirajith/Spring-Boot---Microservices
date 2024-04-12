if [ -z "${MONGODB_USERNAME}" ] || [ -z "${MONGODB_PASSWORD}" ]; then
  echo "Error: Missing required environment variables. Please set MONGODB_USERNAME and MONGODB_PASSWORD."
  exit 1
fi

# Run your config-server application here
exec java -jar your-config-server.jar