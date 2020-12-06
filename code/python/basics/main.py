class Car:
    def __init__(self, brand, model, licence):
        self.brand = brand
        self.model = model
        self._licence = licence

    @property
    def licence(self):
        print("getter of licence called")
        return self._licence

    @licence.setter
    def licence(self, value):
        print("setter of licence called")
        if len(value) != 7:
            raise ValueError("licence must be LLNNNLL")
        if not all(isinstance(x, str) for x in value[0:2]):
            raise ValueError("licence must be LLNNNLL")
        if not all(isinstance(x, str) for x in value[-2:]):
            raise ValueError("licence must be LLNNNLL")
        if not all(x.isnumeric() for x in value[2:5]):
            raise ValueError("licence must be LLNNNLL")
        self._licence = value

    @licence.deleter
    def licence(self):
        print("deleter of licence called")
        del self._licence


if __name__ == '__main__':
    m3 = Car('Bmw', 'M3', 'GY455AI')
    print(m3.licence)
    print(m3.__dict__)

