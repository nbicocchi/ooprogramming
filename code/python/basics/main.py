class Car:
    def __init__(self, brand, model):
        self.brand = brand
        self.model = model

    def __repr__(self):
        return '{} {}'.format(self.brand, self.model)


if __name__ == '__main__':
    x = 4+3j
    print(x.real, "+", x.imag, 'i')
    x = 4.5
    print(x.is_integer())
    x = 4.0
    print(x.is_integer())



