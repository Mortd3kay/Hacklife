from django.conf.urls import url, include
from rest_framework import routers
from map.views import *
from .views import UserViewset

api_router = routers.SimpleRouter()
api_router.register(r'users', UserViewset)

app_name = "map"

urlpatterns = [
    url(r'', include(api_router.urls)),
    url(r'^users/$', UserViewset.as_view(), name='user-list'),

]