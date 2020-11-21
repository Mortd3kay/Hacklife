from rest_framework import viewsets
from .models import *
from .serializers import UserSerializer


class BaseViewSet(viewsets.ModelViewSet):
    def get_queryset(self):
        return self.model.objects.all()


class UserViewset(BaseViewSet):
    serializer_class = UserSerializer
    model = User