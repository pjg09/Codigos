import qrcode

input = 'https://proyecto1789.github.io/index.html'

qr = qrcode.QRCode(version=1,box_size=30,border=5)

qr.add_data(input)
qr.make(fit=True)

img = qr.make_image(fill='black',back_color='white')
img.save('qrlina.png')