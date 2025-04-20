import abc
from abc import ABC, abstractmethod

class IReparar(ABC):
    
    @abstractmethod
    def reparar(self):
        pass