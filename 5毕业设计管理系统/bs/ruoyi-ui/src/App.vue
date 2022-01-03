<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
import {snowing} from '@/assets/snow.js'
export default  {
  name:  'App',
    metaInfo() {
        return {
            title: this.$store.state.settings.dynamicTitle && this.$store.state.settings.title,
            titleTemplate: title => {
                return title ? `${title} - ${process.env.VUE_APP_TITLE}` : process.env.VUE_APP_TITLE
            }
        }
    },
  created() {
    this.snow();
  },
  methods:{
    snow(){
      snowing()
    },
  }
}
</script>
<style>
@keyframes snowTranstion {
  0%{transform: rotate(0deg)}
  100%{transform: rotate(180deg)}
}
.move{
  animation: snowTranstion 1s infinite linear;
}

</style>
