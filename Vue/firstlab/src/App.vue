<template>
  
  <FormVue/>
  
</template>

<script>
import FormVue from './components/forms.vue'

export default {
  name: 'App',
  components: {
    FormVue,
},
data(){
  return{
    choice:1
  }
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
