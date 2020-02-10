from urllib.parse import quote_plus
import hmac
import hashlib
import base64


def generate(parameters, secret_key):
    sorted_keys = sorted(parameters)

    parameter_strs = []

    for key in sorted_keys:
        value = quote_plus(parameters[key], encoding='utf-8')

        parameter_strs.append(key + '=' + value)

    parameter_str = '&'.join(parameter_strs)

    digest = hmac.new(secret_key.encode('utf-8'),
                      parameter_str.encode('utf-8'), hashlib.sha1).digest()

    return str(base64.b64encode(digest), 'utf-8')


if __name__ == '__main__':
    access_key = 'abc'
    secret_key = '1234qwer'

    parameters = {}

    parameters['key1'] = 'value1'
    parameters['key3'] = 'value 3'
    parameters['key2'] = 'v a lue2'

    parameters['accesskey'] = access_key

    signature = generate(parameters, secret_key)

    print(type(signature))

    print('signature: %s' % signature)
