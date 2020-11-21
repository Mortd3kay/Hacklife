# Generated by Django 3.1.2 on 2020-11-21 16:33

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Admin',
            fields=[
                ('ID_ad', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='Айдишник админа')),
                ('Email_ad', models.CharField(max_length=45, unique=True, verbose_name='Почта админа')),
                ('FIO_ad', models.CharField(max_length=45, verbose_name='Инициалы админа')),
                ('Password_ad', models.CharField(max_length=45, verbose_name='Пароль админа')),
            ],
        ),
        migrations.CreateModel(
            name='Post',
            fields=[
                ('ID_post', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='Айдишник поста')),
                ('Name_post', models.CharField(max_length=45, verbose_name='Название поста')),
                ('Discription', models.CharField(max_length=45, verbose_name='Описание')),
                ('Approve_flag', models.BooleanField(default=False)),
            ],
        ),
        migrations.CreateModel(
            name='User',
            fields=[
                ('ID', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='Айдишник')),
                ('Email', models.CharField(max_length=45, unique=True, verbose_name='Почта')),
                ('FIO', models.CharField(max_length=45, verbose_name='Инициалы')),
                ('Password', models.CharField(max_length=45, verbose_name='Пароль')),
            ],
        ),
        migrations.CreateModel(
            name='UserType',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('Type_user', models.CharField(choices=[('B', 'Business'), ('E', 'Expert'), ('C', 'Common')], max_length=3, verbose_name='Типы пользователей')),
                ('ID_user', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='map.user')),
            ],
        ),
        migrations.CreateModel(
            name='Upvotes',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('Id_post', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='Post_id_up', to='map.post', verbose_name='Айди поста')),
                ('User_id', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='User_id_up', to='map.user', verbose_name='Айди юзера')),
            ],
        ),
        migrations.CreateModel(
            name='PostType',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('Type_post', models.CharField(choices=[('P', 'Post'), ('Ev', 'Event'), ('BO', 'Buisness-offer')], max_length=3, verbose_name='Типы постов')),
                ('Id_post', models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.SET_NULL, related_name='Post_id', to='map.post', verbose_name='Айди поста')),
            ],
        ),
        migrations.AddField(
            model_name='post',
            name='Creator_id',
            field=models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.SET_NULL, related_name='User_id', to='map.user', verbose_name='Айди юзера'),
        ),
        migrations.CreateModel(
            name='Chat',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('Date', models.DateField(max_length=4, verbose_name='Дата отправки сообщения')),
                ('Text', models.CharField(max_length=150, verbose_name='Текст сообщения')),
                ('Id_post', models.ForeignKey(blank=True, on_delete=django.db.models.deletion.CASCADE, related_name='Post_id_exist', to='map.post', verbose_name='Айди поста')),
                ('User_id', models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.SET_NULL, related_name='User_id_exist', to='map.user', verbose_name='Айди юзера')),
            ],
        ),
        migrations.CreateModel(
            name='Address',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('Address', models.CharField(max_length=40, verbose_name='Адрес')),
                ('Width', models.FloatField(verbose_name='Широта')),
                ('Height', models.FloatField(verbose_name='Долгота')),
                ('Id_post', models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='Post_id_address', to='map.post', verbose_name='Айди поста')),
            ],
        ),
    ]
