class Car:
    def __init__(self, brand, model):
        self.brand = brand
        self.model = model

    def __repr__(self):
        return '{} {}'.format(self.brand, self.model)
    

if __name__ == '__main__':
    m3 = Car('Bmw', 'M3')
    print(m3)
    print(repr(m3))
