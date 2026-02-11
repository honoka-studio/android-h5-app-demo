import defaultAndroidInterfaces from '@honoka/js-utils/android/async-interface/index'
import androidInterfaceStubUtils from '@honoka/js-utils/android/async-interface/stub-utils'
import testInterfaceStub from '@/android-interfaces/stub/test'
import messageUtils from '@/utils/message'

androidInterfaceStubUtils.showErrorMsg = messageUtils.error

const androidInterfaces = {
  ...defaultAndroidInterfaces,
  test: testInterfaceStub
}

export default androidInterfaces
