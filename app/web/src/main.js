import '@/assets/main.scss'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from '@/App.vue'
import router from '@/router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'vant/lib/index.css'
import eventListenerUtils from '@honoka/js-utils/android/event-listener'

eventListenerUtils.exposeToGlobal()

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(ElementPlus)

app.mount('#app')
