import androidInterfaceStubUtils from '@honoka/js-utils/android/async-interface/stub-utils'
import codeUtils from '@honoka/js-utils/basic/code'

//noinspection JSUnusedGlobalSymbols
const definition = {
  test: () => {},
  asyncMethodTest: {
    isAsync: true,
    fallback: async (a, b) => {
      await codeUtils.sleep(3000)
      return {
        sum: a + b
      }
    }
  }
}

const testInterfaceStub = androidInterfaceStubUtils.getStub(
  'TestJsInterface', definition
) ?? definition

export default testInterfaceStub
