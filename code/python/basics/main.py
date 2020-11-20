class Car:
    # class attribute
    wheels = 4

    # instance attribute
    def __init__(self, brand, model):
        self.brand = brand
        self.model = model


if __name__ == '__main__':
    m3 = Car('Bmw', 'M3')
    tsla = Car('Tesla', 'Roadster')

    print("Wheels={}".format(m3.__class__.wheels))
    print("Brand={}, Model={}".format(m3.brand, m3.model))

    print("Wheels={}".format(tsla.__class__.wheels))
    print("Brand={}, Model={}".format(tsla.brand, tsla.model))

