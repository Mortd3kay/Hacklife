from django.db import models

# Create your models here.


class User(models.Model):
    Types = (
        ('B', 'Business'),
        ('E', 'Expert'),
        ('C', 'Common')
    )

    ID = models.AutoField("Айдишник", primary_key=True, auto_created=True, serialize=False)
    Email = models.CharField("Почта", max_length=45, unique=True)
    FIO = models.CharField("Инициалы", max_length=45, null=False)
    Password = models.CharField("Пароль", max_length=45, null=False)
    Type_user = models.CharField("Типы пользователей", max_length=3, choices=Types, blank=False, default="C")

    def __str__(self):
        return self.ID


class Admin(models.Model):
    ID_ad = models.AutoField("Айдишник админа", primary_key=True, auto_created=True, serialize=False)
    Email_ad = models.CharField("Почта админа", max_length=45, unique=True)
    FIO_ad = models.CharField("Инициалы админа", max_length=45, null=False)
    Password_ad = models.CharField("Пароль админа", max_length=45, null=False)

    def __str__(self):
        return self.ID_ad


class Post(models.Model):
    Types = (
        ('P', 'Post'),
        ('Ev', 'Event'),
        ('BO', 'Buisness-offer')
    )

    ID_post = models.AutoField("Айдишник поста", primary_key=True, auto_created=True, serialize=False)
    Name_post = models.CharField("Название поста", max_length=45, null=False)
    Description = models.TextField("Описание", null=True, blank=True)
    Creator_id = models.ForeignKey(User, null=True, blank=True, on_delete=models.SET_NULL, related_name='User_id', verbose_name="Айди юзера")
    Approve_flag = models.BooleanField(default=False)
    Type_post = models.CharField("Типы постов", max_length=3, choices=Types, blank=False, default="P")

    def __str__(self):
        return self.ID_post


class Chat(models.Model):
    Id_post = models.ForeignKey(Post, null=False, blank=True, on_delete=models.CASCADE, related_name='Post_id_exist',verbose_name="Айди поста")
    Date = models.DateField("Дата отправки сообщения", max_length=4)
    User_id = models.ForeignKey(User, null=True, blank=True, on_delete=models.SET_NULL, related_name='User_id_exist', verbose_name="Айди юзера")
    Text = models.TextField("Текст сообщения", null=True, blank=True)

    def __str__(self):
        return self.Id_post


class Address(models.Model):
    Id_post = models.ForeignKey(Post, null=True, on_delete=models.CASCADE, related_name='Post_id_address', verbose_name="Айди поста")
    Address = models.CharField("Адрес", max_length=40, null=False)
    Width = models.FloatField("Широта")
    Height = models.FloatField("Долгота")

    def __str__(self):
        return self.Id_post


class Upvotes(models.Model):
    Id_post = models.ForeignKey(Post, null=False, on_delete=models.CASCADE, related_name='Post_id_up', verbose_name="Айди поста")
    User_id = models.ForeignKey(User, null=False, on_delete=models.CASCADE, related_name='User_id_up',verbose_name="Айди юзера")

    def __str__(self):
        return self.User_id