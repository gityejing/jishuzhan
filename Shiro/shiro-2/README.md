### ���ʹ�õ�¼��֤����Ȩ

1. ��Ȩ��Ҫ�̳� AuthorizingRealm ��, ��ʵ���� doGetAuthorizationInfo ����
2. AuthorizingRealm ��̳��� AuthenticatingRealm, ��û��ʵ�� AuthenticatingRealm �е� 
doGetAuthenticationInfo, ������֤����Ȩֻ��Ҫ�̳� AuthorizingRealm �Ϳ�����. ͬʱʵ�������������󷽷�.

### ���� 

1. Ϊʲôʹ�� MD5 ��ֵ����: 
2. �������:
1). �� doGetAuthenticationInfo ��������ֵ���� SimpleAuthenticationInfo �����ʱ��, ��Ҫʹ��
SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName) ������
2). ʹ�� ByteSource.Util.bytes() ��������ֵ. 
3). ��ֵ��ҪΨһ: һ��ʹ������ַ����� user id
4). ʹ�� new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations); ��������ֵ���ܺ�������ֵ. 

### ����ļ����㷨

1. ��ΰ�һ���ַ�������Ϊ MD5 
2. �滻��ǰ Realm �� credentialsMatcher ����. ֱ��ʹ�� HashedCredentialsMatcher ����, �����ü����㷨����. 

### ��������ô��������ȶԵ�
����ıȶ�:
ͨ�� AuthenticatingRealm �� credentialsMatcher ���������е�����ıȶ�!


### ����shiro��ܣ����е�¼��֤�����̲��裺

1. ��ȡ��ǰ�ĵ�¼�û�Subject������ SecurityUtils.getSubject();
2. ���Ե�ǰ���û��Ƿ��Ѿ�����֤. ���Ƿ��Ѿ���¼. ���� Subject �� isAuthenticated() 
3. ��û�б���֤, ����û����������װΪ UsernamePasswordToken ����

	����������������controller��ʵ�֣������������
	1). ����һ������ҳ��
	2). �������ύ�� SpringMVC �� controller
	3). ��ȡ�û���������. 

4. ִ�е�¼: ���� Subject �� login(AuthenticationToken) ����. 
5. �Զ��� Realm �ķ���, �����ݿ��л�ȡ��Ӧ�ļ�¼, ���ظ� Shiro.

	1). ʵ������Ҫ�̳� org.apache.shiro.realm.AuthenticatingRealm ��
	2). ʵ�� doGetAuthenticationInfo(AuthenticationToken) ����. 
	
6. �� shiro ��ɶ�����ıȶ�. 