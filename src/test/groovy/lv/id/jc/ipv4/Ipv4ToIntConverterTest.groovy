package lv.id.jc.ipv4

import spock.lang.Specification
import spock.lang.Title

@Title('IPv4 Converter')
class Ipv4ToIntConverterTest extends Specification {

    def 'should convert string representation of IPv4 to int'() {
        given:
        def converter = new Ipv4ToIntConverter()

        when:
        def actual = converter.applyAsInt(ip)

        then:
        actual == expected

        where:
        ip         | expected
        '0.0.0.0.' | 0
        '0.0.0.1'  | 1
        '0.0.1.0'  | 256
        '0.0.1.44' | 300
        '0.1.0.0'  | 65536
        '0.1.1.0'  | 65792

    }
}
