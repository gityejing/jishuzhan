#���ͨ��ע������ȡproperties�����ļ�#

ʵ�ֲ���

```txt

����ͨ��
@PropertySource(
	value = 
		{
			"jdbc.properties",
			"classpath:common.properties",
			"classpath:abc.properties"
		}
)
���������ļ�.

Ȼ����ͨ��@Value("${destinationLocation}")ȥ��ȡʵ�ʵļ�ֵ

```

һ��Сʵ�飺
>
����@PropertySource���õ�λ�ã����Ƿ����������ļ������ϣ����е�����bean�����Զ�ȡ����
�����Ƶ�ĳһ��ָ��������bean�ϣ����е�����bean���ǿ��Զ�ȡ����

@Value�е��﷨

```txt
1��
2��
3��
```

