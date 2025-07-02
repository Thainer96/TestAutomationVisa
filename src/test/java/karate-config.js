function fn() {
  karate.configure('ssl', true);

  var config = {
    urlBase: 'http://localhost:8080/api/v3/'
  };

  return config;
}