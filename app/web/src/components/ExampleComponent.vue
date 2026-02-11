<template>
  <div>
    <p>
      <span>Element Plus Test:</span>
      <el-button @click="elementPlusTest">Test</el-button>
    </p>
    <p>
      <span>Vant Test:</span>
      <van-button plain type="primary" @click="vantTest">Vant Button</van-button>
    </p>
    <p>
      <span>Android JavaScript Interface:</span>
      <el-button @click="androidInterfaceTest">Test</el-button>
    </p>
    <p>
      <span>开启一个新的WebActivity：</span>
      <el-button @click="openNewWebActivityTest">开启</el-button>
    </p>
    <p>
      <span>Android Asynchronous Method:</span>
      <el-button @click="androidAsyncMethodTest" :loading="status.androidAsyncMethodTestLoading">Test</el-button>
    </p>
    <p>
      <span>锁定返回动作：</span>
      <el-button @click="switchLockBackAction">{{ status.lockBackAction ? '解锁' : '锁定' }}</el-button>
    </p>
  </div>
</template>

<script setup>
import androidInterfaces from '@/android-interfaces'
import messageUtils from '@/utils/message'
import eventListenerUtils from '@honoka/js-utils/android/event-listener'
import { showToast } from 'vant'
import { getCurrentInstance, reactive } from 'vue'

const status = reactive({
  androidAsyncMethodTestLoading: false,
  lockBackAction: false,
})

function elementPlusTest() {
  messageUtils.success('Test')
}

function vantTest() {
  showToast('Test')
}

function androidInterfaceTest() {
  androidInterfaces.test.test()
}

function openNewWebActivityTest() {
  androidInterfaces.basic.openNewWebActivity('/another')
}

function androidAsyncMethodTest() {
  let a = Math.floor(Math.random() * 100) + 1
  let b = Math.floor(Math.random() * 100) + 1
  status.androidAsyncMethodTestLoading = true
  messageUtils.success(`${a} + ${b}`)
  androidInterfaces.test.asyncMethodTest(a, b).then(res => {
    messageUtils.success(`sum: ${res.sum}`)
  }).finally(() => {
    status.androidAsyncMethodTestLoading = false
  })
}

function switchLockBackAction() {
  status.lockBackAction = !status.lockBackAction
  if(status.lockBackAction) {
    let locker = () => {
      showToast('拦截了返回事件')
      return true
    }
    eventListenerUtils.listeners.onBackButtonPressed[getCurrentInstance()] = [locker]
  } else {
    delete eventListenerUtils.listeners.onBackButtonPressed[getCurrentInstance()]
  }
}
</script>

<style scoped lang="scss">
p {
  display: flex;
  align-items: center;

  span {
    margin-right: 1em;
  }
}
</style>
