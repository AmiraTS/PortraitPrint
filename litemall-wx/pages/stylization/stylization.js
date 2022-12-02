// pages/stylization/stylization.js
Page({
  data: {
    upload_pic:'',
    currentIndex: 0,
    currentIndex1: 0,
    currentIndex2: 0,
    imgList1: [{
      img: "/static/images/style1.png",
      style:"风格1"
    },
    {
      img: "/static/images/style2.png",
      style:"风格2"
    },
    {
      img: "/static/images/style3.png",
      style:"风格3"
    }
    ],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var pic=wx.getStorageSync('key')
    this.setData({
      upload_pic:pic
    })
  },

  design:function(){
    wx.navigateTo({
      url: '../designResult/designResult',
    })
  },


  changeSwiper1: function (e) {
    this.setData({
      currentIndex1: e.detail.current
    })
  },

})