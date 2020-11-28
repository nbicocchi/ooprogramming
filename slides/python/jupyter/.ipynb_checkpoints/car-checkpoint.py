class Car:
    def __init__(self, brand, model, speed=0):
        self.brand = brand
        self.model = model
        self.speed = speed
    
    def speed_up(self):
        self.speed += 1
        
    def speed_down(self):
        self.speed -= 1
        
    def __repr__(self):
        return 'Brand={}, Model={}, Speed={}'.format(
            self.brand, 
            self.model, 
            self.speed)
    
class ECar(Car):
    def __init__(self, brand, model, speed=0, battery_level=0):
        super().__init__(brand, model, speed)
        self.battery_level = battery_level
        
    # overriden methods
    def speed_up(self):
        self.speed += 2
        
    def speed_down(self):
        self.speed -= 2

    # additional methods
    def charge(self):
        self.battery_level += 1
        
    def discharge(self):
        self.battery_level += 1
        
    def __repr__(self):
        return 'Brand={}, Model={}, Speed={}, Battery={}'.format(
            self.brand, 
            self.model, 
            self.speed,
            self.battery_level)
    
    
    