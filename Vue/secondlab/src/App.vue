<template>
<!-- npm i vue-router@4 -->
<!-- npm i axios -->
<div>
<navigationApp/>
<router-view></router-view>
</div>
</template>
<script>

import navigationApp from './components/navigation.vue'
export default {
  name: 'App',
  components: {
    navigationApp
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
