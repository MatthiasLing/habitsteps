module.exports = {
  // added after
  outputDir: 'target/dist',
  assetsDir: 'static',


    devServer: {
      proxy: {
        '^/api': {
          target: 'http://localhost:8080',
          changeOrigin: true
        },
      }
    }
  }