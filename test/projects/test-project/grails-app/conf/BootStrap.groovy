class BootStrap {
    def init = { servletContext ->
        println "To execute tests, go to: http://localhost:8080/test-project/jasmineTest/index"
    }
    def destroy = {
    }
}
