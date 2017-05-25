package com.avvero.bot_aes_encryption.utils

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by Avvero on 25.05.2017.
 */

class UtilsTests extends Specification {

    @Unroll
    def "Extraction"() {
        expect:
        Utils.extract(s) == r
        where:
        s                                                                                                                          | r
        "<a href=\"mailto:ws_2017-05-25-02@belyaev.mx.dev.fxclub.org123456\">ws_2017-05-25-02@belyaev.mx.dev.fxclub.org123456</a>" | "ws_2017-05-25-02@belyaev.mx.dev.fxclub.org123456"
        "ws_2017-05-25-02@belyaev.mx.dev.fxclub.org123456"                                                                         | "ws_2017-05-25-02@belyaev.mx.dev.fxclub.org123456"
    }

}
