import testInterfaceStub from '@/android-interfaces/stub/test'
import defaultAndroidInterfaces from '@honoka/js-utils/src/android/async-interface'
import androidInterfaceStubUtils from '@honoka/js-utils/src/android/async-interface/stub-utils'
import messageUtils from '@/utils/message'

androidInterfaceStubUtils.showErrorMsg = messageUtils.error

const androidInterfaces = {
  ...defaultAndroidInterfaces,
  test: testInterfaceStub
}

export default androidInterfaces
