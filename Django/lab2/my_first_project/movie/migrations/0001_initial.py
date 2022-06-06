# Generated by Django 4.0.4 on 2022-06-05 17:01

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('actor', '0006_alter_actor_profile_img'),
    ]

    operations = [
        migrations.CreateModel(
            name='Movie',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=50, verbose_name='Movie Name')),
                ('production_year', models.DateField(null=b'I01\n')),
                ('creation_time', models.DateTimeField(auto_now_add=True, null=b'I01\n')),
                ('update_time', models.DateTimeField(auto_now=True, null=b'I01\n')),
                ('actors', models.ManyToManyField(to='actor.actor')),
            ],
        ),
    ]